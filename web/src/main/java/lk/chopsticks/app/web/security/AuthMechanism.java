package lk.chopsticks.app.web.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.authentication.mechanism.http.AutoApplySession;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@AutoApplySession
@ApplicationScoped
public class AuthMechanism implements HttpAuthenticationMechanism {

    @Inject
    private IdentityStore identityStore;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest req, HttpServletResponse resp, HttpMessageContext ctx) throws AuthenticationException {

        AuthenticationParameters authParameters = ctx.getAuthParameters();

        if(authParameters.getCredential() != null){
            CredentialValidationResult result = identityStore.validate(authParameters.getCredential());
            if(result.getStatus() == CredentialValidationResult.Status.VALID){
                return ctx.notifyContainerAboutLogin(result);
            }else {
                return AuthenticationStatus.SEND_FAILURE;
            }
        }

        if(ctx.isProtected() && ctx.getCallerPrincipal() == null){
            try {
                 resp.sendRedirect(req.getContextPath() + "/login.jsp");
             } catch (IOException e) {
                 throw new RuntimeException("Redirect to login failed: ",e);
             }
        }

        return ctx.doNothing();
    }
}
