package com.musicsamplesite.service;

import com.musicsamplesite.model.Album;
import com.musicsamplesite.model.Albums;
import com.musicsamplesite.model.Artists;
import com.musicsamplesite.model.Track;
import com.musicsamplesite.utils.HttpConnectionUtils;
import com.musicsamplesite.utils.SIMHRestTemplate;
import com.musicsamplesite.utils.UrlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Search service.
 */
@Service("apiService")
public class APIServiceImpl implements APIService {

    private static final Logger logger = LoggerFactory.getLogger(APIServiceImpl.class);

    private SIMHRestTemplate restTemplate;

    /**
     * Instantiates a new API service.
     *
     * @param httpConnectionUtils the http connection utils
     */
    @Autowired
    public APIServiceImpl(HttpConnectionUtils httpConnectionUtils) {
        this.restTemplate = new SIMHRestTemplate(httpConnectionUtils);

    }


    @Override
    public List<Track> getTopFiveTracks(int artistId) { //TODO: request top 5 tracks
        return null;
    }

    @Override
    public Artists searchArtist(String userInput) throws Exception {
        String urlQuery = UrlUtils.buildArtistSearchQuery(userInput);

        return restTemplate.get(urlQuery, Artists.class);
    }

    @Override
    public Album getAlbumByAlbumId(Integer albumId) throws Exception {
        String url = UrlUtils.buildAlbumDetailURL(albumId);
        return restTemplate.get(url, Album.class);
    }

    @Override
    public Albums getAlbumsByArtistId(Integer artistId) throws Exception {

        String url = UrlUtils.buildAlbumLinkURL(artistId);

        return restTemplate.get(url, Albums.class);
    }


}
