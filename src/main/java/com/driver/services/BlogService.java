package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
    	return blogRepository1.findAll();
        //find all blogs

    }

    public void createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog();
        
        blog.setId( userId );
        blog.setTitle( title );
        blog.setContent( content );
        blog.setPubDate(new Date() );
        
        User user = userRepository1.findById(userId).get();
        blog.setUser(user);
        //updating the blog details
        //Updating the userInformation and changing its blogs
        List<Blog> bloglists = user.getBlogList();
        bloglists.add( blog );
        user.setBlogList(bloglists);
        
        //calling only the parent so the child blog will automatically be save beacause of the 
        // bidirectional mapping
        userRepository1.save( user );
    }

    public Blog findBlogById(int blogId){
        //find a blog
        return blogRepository1.findById(blogId).get();
    }

    public void addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog after creating it
        Blog  blog = blogRepository1.findById(blogId).get();
        
        Image img = this.imageService1.createAndReturn( blog, description, dimensions );
        // new Image();
        // img.setDescription( description );
        // img.setDimensions( dimension );

        List<Image> imges = blog.getImageList();
        imges.add( img );
        blog.setImageList(imges);
        
        blogRepository1.save(blog);

        
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
    	Blog blog = blogRepository1.findById(blogId).get();
    	blogRepository1.delete(blog);
    }
}
