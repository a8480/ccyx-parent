package com.zxwcbj.ccyx.sys.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxwcbj.ccyx.model.sys.Ware;
import com.zxwcbj.ccyx.sys.mapper.WareMapper;
import com.zxwcbj.ccyx.sys.service.WareService;
import org.springframework.stereotype.Service;

@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {

}
