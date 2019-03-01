package mybatis;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.xyt.Application;
import com.xyt.mapper.ArticleMapper;
import com.xyt.mapper.BookMapper;
import com.xyt.model.Article;
import com.xyt.model.Book;
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
    public void addArticle(){
        Article article = new Article();
        article.setAuthorId(123);
        article.setTitle("tom");
        article.setCreatedDate(new Date());
        article.setContent("okay");
        articleMapper.insertArticle(article);
    }
    @Test
    public void updateArticle(){
        articleMapper.updateArticle(1,"wow","new title",new Date());
    }
    @Test
    public void deleteArticle(){
        articleMapper.deleteArticle(1);
        System.out.println("--end----");

    }
    @Test
    public void insertIntohistory(){
        Article article = articleMapper.getArticleById(2);
        System.out.println(article.getAuthorId());
        //articleMapper.insertArticleToHistory(article,new Date());
    }
    @Test
    public void insertIntoHistory(){
        Article article = articleMapper.getArticleById(2);
        articleMapper.insertArticleToHistory(article,new Date());
    }
}
