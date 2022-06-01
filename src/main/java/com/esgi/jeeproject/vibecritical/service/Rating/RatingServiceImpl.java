package com.esgi.jeeproject.vibecritical.service.Rating;

import com.esgi.jeeproject.vibecritical.domain.Rating.Rating;
import com.esgi.jeeproject.vibecritical.repositories.Rating.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService{
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(Long ratingId) {
        return ratingRepository.getById(ratingId);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }
}
