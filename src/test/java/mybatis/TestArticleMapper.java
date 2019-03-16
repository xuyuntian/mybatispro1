package mybatis;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.xyt.Application;
import com.xyt.entity.Article;
import com.xyt.mapper.ArticleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestArticleMapper {
    @Autowired
    ArticleMapper articleMapper;
    @Test
    public void testInsertArticle(){//通过了测试
        Article[] articles = new Article[50];
        for(int i =0;i<50;i++){
            articles[i] = new Article();
            articles[i].setParentId(i%10);
            articles[i].setTitle("titles"+i);
            articles[i].setContent("content"+i);
        }//测试插入数据
        for(Article article: articles){
            articleMapper.insertArticle(article);
        }
    }
    @Test
    public void testupdateArticle(){
        //测试通过
        Article article = new Article();
        article.setId(1);
        article.setParentId(111);
        article.setContent("update后的content");
        article.setTitle("update后的tltel");
        articleMapper.updateArticle(article);
    }
    @Test
    public void testSelectArticleById(){
        //通过了测试
        Article article = articleMapper.selectArticleById(1);
        System.out.println(article.getId()+","+article.getParentId()+","+article.getTitle()+","+article.getContent());
    }
    @Test
    public void testSelectArticlesByParentId(){
        //通过了测试
        List<Article> articles = articleMapper.selectArticlesByParentId(1);
        for(Article article : articles){
            System.out.println(article.getId()+","+article.getParentId()+","+article.getTitle()+","+article.getContent());
        }
    }
    @Test
    public void testDeleteArticleById(){
        articleMapper.deleteArticleById(50);
    }
}
