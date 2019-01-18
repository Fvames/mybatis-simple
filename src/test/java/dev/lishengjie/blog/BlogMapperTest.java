package dev.lishengjie.blog;

import com.sun.xml.internal.rngom.parse.host.Base;
import dev.lishengjie.BaseTest;
import dev.lishengjie.beans.Blog;
import dev.lishengjie.beans.BlogExample;
import dev.lishengjie.beans.Posts;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by James on 2019/1/14.
 */
public class BlogMapperTest extends BaseTest{
    private final static Logger log = LoggerFactory.getLogger(BlogMapperTest.class);
    @Autowired
    private BlogMapper mapper;

    @Test
    public void insertBlog() {

        Blog blog = new Blog();
        blog.setAuthorId(1);
        blog.setContent("first content of blog");
        blog.setTitle("first blog");
        mapper.insertSelective(blog);
    }

    @Test
    public void selectBlog() {

        Blog blog = new Blog();
        blog.setAuthorId(1);
        BlogExample example = new BlogExample();
        //List<Blog> blogs = mapper.selectByExample(example);
        Blog blogs = mapper.selectByPrimaryKey(1);
        System.out.println("blogs: "+ blogs.toString());
    }

    @Test
    public void selectBlogAuthor() throws InterruptedException {//one to one 嵌套结果
        //Blog resultMap = mapper.selectBlogAuthor(1);

        // 嵌套查询
        //Blog resultMap = mapper.selectBlogAuthor嵌套结果(1);

        List<Blog> resultMap = mapper.selectBlogPosts嵌套结果(1);
        System.out.println(resultMap.size());
        System.out.println(resultMap.get(0).getTitle());
        //Thread.sleep(5000);

        //System.out.println(resultMap.get(0).getPosts().get(1).getContent());
    }

    /*@Test
    public void selectByBlogId() {
        List<Posts> resultMap = mapper.selectByBlogId(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套结果() {//one to many 嵌套结果
        BlogPostsResultMap resultMap = mapper.selectBlogPosts2(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectBlogPosts嵌套查询() throws InterruptedException {//one to many 嵌套查询
        BlogPostsResultMap resultMap = mapper.selectBlogPosts(1);
        System.out.println(resultMap.getPosts().get(0).getPostName());
        Thread.sleep(5000);
        System.out.println(resultMap.getName());
    }

    //N+1问题
    @Test
    public void selectBlogPosts嵌套查询N1() throws InterruptedException {//one to many 嵌套查询
        //这里是1次
        List<BlogPostsResultMap> resultMap = mapper.selectBlogPostsList(0);
        System.out.println(resultMap.get(0).getName());
        Thread.sleep(5000);
        //当要使用的时候他们再去拉取数据 这里就是N次
        System.out.println(resultMap.get(0).getPosts().get(0).getPostName());
        System.out.println(resultMap.get(1).getPosts().get(0).getPostName());
        //1次 + N次
    }

    @Test
    public void selectByAuthorId嵌套查询() {//one to one 嵌套查询
        Blog resultMap = mapper.selectBlogAuthor(1);
        System.out.println(resultMap);
    }

    @Test
    public void selectByAuthorId2() {//one to one 嵌套结果
        Blog resultMap = mapper.selectBlogAuthor2(1);
        System.out.println(resultMap);
    }*/


}
