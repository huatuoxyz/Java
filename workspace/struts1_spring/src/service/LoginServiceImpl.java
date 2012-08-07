package service;
import org.springframework.stereotype.Service;

@Service("loginService")                                          //(1)
public class LoginServiceImpl implements LoginService{
    public boolean execute(String userId, String password){
        if("spring".equals(userId) && "spring".equals(password)){
          return true;
        }
        return false;
    }
}
