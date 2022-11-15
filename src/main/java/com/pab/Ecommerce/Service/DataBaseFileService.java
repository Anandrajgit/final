//package com.pab.Ecommerce.Service;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.multipart.MultipartFile;
//import com.pab.Ecommerce.BeanClass.ProductDetails;
//import com.pab.Ecommerce.Repository.ProductRepository;
//import com.pab.Ecommerce.exception.FileStorageException;
//
//import org.springframework.util.StringUtils;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DataBaseFileService {
//
//    @Autowired
//    private ProductRepository dbFileRepository;
//
//    public ProductDetails storeFile(MultipartFile file,ProductDetails u) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Check if the file's name contains invalid characters
//            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//
//            ProductDetails dbFile = new ProductDetails(fileName, file.getContentType(), file.getBytes(),u.getCompName(), u.getCateName(), u.getProcId(),u.getProcName(), u.getDescription(),u.getPrice());
//            return dbFileRepository.save(dbFile);	
//        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
//        }
//    }
//    
//    public ProductDetails getFile(String id) {
//        return dbFileRepository.findById(id).get();
//    }
//    
//    public List<ProductDetails> getMobileDetails(){
//		return dbFileRepository.findAll();
//    	
//    }
//    
////    public ProductDetails getFile(String fileId) {
////        return dbFileRepository.findById(fileId)
////            .orElseThrow(() - > new FileNotFoundException("File not found with id " + fileId));
////    }
//}
