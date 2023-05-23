package com.example.userservice.Dto;

import javax.persistence.*;

public class ProductDto {
        private  long product_id;
        private String name;
        private String sku;
        private String images;
        private String description;

        @Override
        public String toString() {
            return "Product{" +
                    "product_id=" + product_id +
                    ", name='" + name + '\'' +
                    ", sku='" + sku + '\'' +
                    ", images='" + images + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }

        public ProductDto(String name, String sku, String images, String description) {
            this.name = name;
            this.sku = sku;
            this.images = images;
            this.description = description;
        }

        public ProductDto() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

