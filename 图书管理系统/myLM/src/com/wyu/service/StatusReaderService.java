package com.wyu.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.wyu.pojo.StatusReader;

@Service
public interface StatusReaderService {

	List<StatusReader> findStatusReader();


}
