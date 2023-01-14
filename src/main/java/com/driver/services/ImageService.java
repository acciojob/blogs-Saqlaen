package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image img = new Image();
        img.setDescription( description );
        img.setDimensions( dimension );
        img.setBlog( blog );

        return img;
    }

    public void deleteImage(Image image){

    }

    public Image findById(int id) {

    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
        int count = 0;
        if( image == null ){
            return 0;
        }else{
            
        }

    }
}
