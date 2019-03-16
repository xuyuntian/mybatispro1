package mybatis;

import com.xyt.Application;
import com.xyt.authorization.UserType;
import com.xyt.entity.MyUser;
import com.xyt.mapper.MyUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMyUser {
    @Autowired
    private MyUserMapper myUserMapper;
    @Test
    public void testInsert(){
        MyUser myUser = new MyUser();
        myUser.setEmail("415@qq.com");
        myUser.setPassword("okay.com");
        myUser.setType(UserType.ADMIN);
        myUserMapper.insertMyUser(myUser);
    }
    @Test
    public void testUpdate(){
        MyUser myUser = new MyUser();
        myUser.setEmail("415@qq.com");
        myUser.setPassword("okay.comfsdafsaf");
        myUser.setType(UserType.ADMIN);
        myUserMapper.updateMyUser(myUser);
    }
    @Test
    public void testget(){
        System.out.println(myUserMapper.getMyUserByEmail("415@qq.com").getPassword());
    }
}
