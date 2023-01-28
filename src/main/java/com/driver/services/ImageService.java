package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.ImageRepository;

import java.util.List;

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
        img.setDimensions( dimensions );
        img.setBlog( blog );

        imageRepository2.save( img );

        return img;
    }

    public void deleteImage(Image image){
        int imageId = image.getId();
        imageRepository2.deleteById( imageId );
    }

    public Image findById(int id) {
        return imageRepository2.findById( id ).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0
    	Image img = image;
        int count = 0;
        if( img == null ){
            return 0;
        }else{
            String imgDimension = img.getDimensions();
            int ximage = 0, yimage = 0, xscreen = 0 , yscreen = 0;
            int num = 0;
            for( int i=0; i<imgDimension.length(); i++ ) {
            	if( imgDimension.charAt(i) == 'X') {
            		ximage = num;
            		num = 0;
            		continue;
            	}
            	num *= 10;
            	num += ( imgDimension.charAt(i) - '0' );
            }
            yimage = num;
            num = 0;
            
            for( int i=0; i<screenDimensions.length(); i++ ) {
            	if( screenDimensions.charAt(i) == 'X' ) {
            		xscreen = num;
            		num = 0;
            		continue;
            	}
            	num *= 10;
            	num += ( screenDimensions.charAt(i) - '0' );
            }
            yscreen = num;
            
            count = (int) (  Math.floor( xscreen / ximage ) * Math.floor( yscreen / yimage ) ) ;
            
        }
        return count;

    }
}
