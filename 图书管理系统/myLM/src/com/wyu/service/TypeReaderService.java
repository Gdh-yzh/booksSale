package com.wyu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.wyu.pojo.TypeReader;

@Service
public interface TypeReaderService {

	List<TypeReader> findTypeReader();


}
