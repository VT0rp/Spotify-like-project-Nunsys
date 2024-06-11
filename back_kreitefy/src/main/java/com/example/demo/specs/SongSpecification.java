package com.example.demo.specs;

import com.example.demo.domain.entity.Song;
import com.example.demo.specs.shared.EntitySpecification;
import com.example.demo.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SongSpecification extends EntitySpecification<Song> implements Specification<Song> {

    public SongSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }
}
