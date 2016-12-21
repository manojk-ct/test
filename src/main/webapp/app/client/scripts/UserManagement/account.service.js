(function (){
    "use strict";

angular.module('app.account')
        .factory('serviceUrl',serviceUrl)
        .factory('tokenStorage',tokenStorage)
        .factory('tokenAuthInterceptor',tokenAuthInterceptor)
        .factory('sessionService',sessionService);

serviceUrl.$inject=['$resource','CONSTANT'];
tokenStorage.$inject=[];
tokenAuthInterceptor.$inject=['$q','tokenStorage'];
sessionService.$inject=['$resource','$state','$http','tokenStorage','logger','$log','CONSTANT'];

function serviceUrl($resource,CONSTANT){  
     return $resource(CONSTANT.SERVICEURL + '/api/login', {}, {
        loginPost: {
            method:'POST',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }
    });
}

function tokenStorage(){
    var storageKey = "tokan-key";
    
    return{
      store: function (tokan){
          return localStorage.setItem(storageKey,tokan);
      },
      retrive:function (){
          return localStorage.getItem(storageKey);
      },
      clear: function (){
          return localStorage.removeItem(storageKey);
      }
    };
}

function tokenAuthInterceptor ($q,tokenStorage){

    return {
      request: function (config){
            var authTokan = tokenStorage.retrive();
            if(authTokan)
            {
                config.headers['X-AUTH-TOKEN'] = authTokan;
            }

            return config;
      },
      requestError :function (error){
          if(error.status === 401 || error.status === 403 )
          {
              tokenStorage.clear();
          }
          $q.reject(error);
      }
      
    };

};

function sessionService($resource,$state,$http,tokenStorage,logger,$log,CONSTANT){

        var userRole={};
        var session ={};
        
        return {
            login:login,
            logout:logout,
            isLoggedIn:isLoggedIn,
            getUserRole:getUserRole,
            loginstatus:loginstatus,
            userRole:userRole
        };
       
        function login(data){
//            var url = window.location;
//            var competeUrl = url.toString();
//            var urls = competeUrl.split('/');
//            var tenantUrl = urls[2].split('.');
//            var tenant = tenantUrl[0].toString();
            localStorage.removeItem("userRole");
            tokenStorage.clear();
            var userData = data;
            var username = userData.username;
            userData.username = "tenant5" + "#"+ username;            
            $http.post(CONSTANT.SERVICEURL +  "/api/login",{username:userData.username,password:userData.password},{
                 headers: {'Content-Type': 'text/plain'}                
                }).success(function (result, status, headers) {
//                        var data = JSON.stringify(result);
//                        var start = data.indexOf("[");
//                        var end = data.indexOf("]");
//                        var role = data.slice(start+2,end-1);
                        tokenStorage.store(headers('X-AUTH-TOKEN'));
                        userRole = JSON.parse(atob(tokenStorage.retrive().split('.')[0]));
                        localStorage.setItem("userRole",userRole.authorities[0].authority);
                        
                        var role  = userRole.authorities[0].authority;
                        
                        if(role === CONSTANT.SADMIN){
                            $state.go("manageTenant");
                        }else  if (role === CONSTANT.DCADMIN){
                            $state.go("dashboard");
                        }else {
                            $state.go("manageRequisition");
                        }
                        logger.logSuccess('Successfully logged in !!');
                        $log.debug("Inside login service (success) " + userRole);
                }).error(function (error) {
                        var data = JSON.stringify(error);
                        var start = data.indexOf(":");
                        var end = data.indexOf(".");                                        
                        var error1 = data.slice(start+2,end);
                        $log.debug("Inside login service (error)" + error1);
                        if(error1==="unauthorized access")
                        {
                            logger.logError("Wrong username/password");
                        }
                });           
            };
            function logout(){
                tokenStorage.clear();
                localStorage.removeItem("userRole");
                session.loginstatus = false;
                $state.go("signin");
            };
            function isLoggedIn(){
//                if(tokenStorage.retrive() !== null)
//                {
//                    session.loginstatus = true;
//                }
//                else
//                {
//                    session.loginstatus = false;
//                }
                return session.loginstatus;
            };
            function getUserRole(){

                return  localStorage.getItem("userRole");
            };
            function loginstatus(){
              return session.loginstatus;  
            };
};
})();