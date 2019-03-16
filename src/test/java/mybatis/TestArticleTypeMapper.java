package mybatis;

import com.xyt.Application;
import com.xyt.entity.ArticleType;
import com.xyt.mapper.ArticleTypeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestArticleTypeMapper {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;
    @Test
    public void TestInsertArticleType(){
        ArticleType articleType = new ArticleType();
        articleType.setName("test1");
        articleTypeMapper.insertArticleType(articleType);
    }
    @Test
    public void TestSelectArticleType(){
        List<ArticleType> articleTypes = articleTypeMapper.selectArticleType();
        for(ArticleType articleType: articleTypes){
            System.out.println(articleType.getId()+","+articleType.getName());
        }
    }
    @Test
    public void TestUpdateArticleType(){
        ArticleType articleType = new ArticleType();
        articleType.setName("update");
        articleType.setId(1);
        articleTypeMapper.updateArticleType(articleType);
    }
    @Test
    public void TestDeleteArticleTypeById(){
        articleTypeMapper.deleteArticleTypeById(1);
    }
}
