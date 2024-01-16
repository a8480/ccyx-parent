package com.zxwcbj.ccyx.search.Repository;

import com.zxwcbj.ccyx.model.search.SkuEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SkuRepository extends ElasticsearchRepository<SkuEs,Long> {
}
