package com.zcon.mobileris.config;


import com.zcon.mobileris.entity.User;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@PropertySource("classpath:mobileris-${env.name}.properties")
/* Description : This class is for tenant resolver for current login user i.e. for switching that database in multitenancy environment */
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String database = "tenant";
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            long userid = ((User) authentication.getDetails()).getId();
            String username = authentication.getName();
            String username_part1 = username.substring(username.indexOf("#") + 1);
            String username_part2 = username.substring(0, username.indexOf("#"));
            database = username_part2;
        }
        return database;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }

}
