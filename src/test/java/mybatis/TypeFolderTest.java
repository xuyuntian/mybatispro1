package mybatis;

import com.xyt.Application;
import com.xyt.entity.TypeFolder;
import com.xyt.mapper.TypeFolderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TypeFolderTest {
    @Autowired
    private TypeFolderMapper typeFolderMapper;
    @Test
    public void testInsert(){
        TypeFolder typeFolder = new TypeFolder();
        typeFolder.setName("testinsert");
        typeFolder.setParentId(1);
        typeFolderMapper.insertTypeFolder(typeFolder);
    }
    @Test
    public void update(){
        TypeFolder typeFolder = new TypeFolder();
        typeFolder.setId(1);
        typeFolder.setName("t666ert");
        typeFolder.setParentId(1);
        typeFolderMapper.updateTypeFolder(typeFolder);
    }
    @Test
    public void select(){
        List<TypeFolder> t = typeFolderMapper.selectTypeFolderMapperByParentId(1);
        for(TypeFolder typeFolder:t){
            System.out.println(typeFolder.getParentId());
        }
    }
    @Test
    public void d(){
        typeFolderMapper.deleteTypeFolderById(1);
    }
}
