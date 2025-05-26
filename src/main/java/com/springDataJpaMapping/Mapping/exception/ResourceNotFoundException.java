package com.springDataJpaMapping.Mapping.exception;

public class ResourceNotFoundException extends RuntimeException{
        public ResourceNotFoundException(String msg){
            super(msg);
        }
}
