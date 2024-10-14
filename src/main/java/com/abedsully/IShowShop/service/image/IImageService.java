package com.abedsully.IShowShop.service.image;

import com.abedsully.IShowShop.dto.ImageDto;
import com.abedsully.IShowShop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImages(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long productId);
}
