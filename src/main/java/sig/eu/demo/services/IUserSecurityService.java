package sig.eu.demo.services;

public interface IUserSecurityService {

    String validatePasswordResetToken(long id, String token);

}
