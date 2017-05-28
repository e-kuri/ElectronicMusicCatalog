package com.example.admin.emc.genres;

import android.support.v7.widget.RecyclerView;

import com.example.admin.emc.R;
import com.example.admin.emc.dao.GenreDaoInMemoryImpl;
import com.example.admin.emc.data.DAO.GenreDao;
import com.example.admin.emc.data.model.Genre;
import com.example.admin.emc.domain.adapter.array.GenreListAdapter;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.adapter.builder.Exception.AdapterBuilderException;
import com.example.admin.emc.domain.callback.IGenreCallback;
import com.example.admin.emc.domain.service.GenreServiceImpl;
import com.example.admin.emc.domain.service.IService.IGenreService;
import com.example.admin.emc.domain.service.exception.ServiceException;
import com.example.admin.emc.presentation.fragment.TopLevelFragment;
import com.example.admin.emc.presentation.presenter.GenrePresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by admin on 8/14/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class GenrePresenterTest {

    private static RecyclerView.Adapter adapter;
    List<Genre> genres;

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private TopLevelFragment view;

    private GenreDao genreDao;

    @Mock
    private IGenreService genreService;

    @Captor
    private ArgumentCaptor<IGenreCallback.GenreListDbCallback> mGenresLoadedCallback;

    @Captor
    private ArgumentCaptor<IGenreCallback.GenreListCallback> mGenreServiceCallback;

    @InjectMocks GenrePresenter presenter;

    @Before
    public void setupGenrePresenter(){
        MockitoAnnotations.initMocks(this);

        presenter.setView(view);

        genres = new ArrayList<>();

        for(Genre.GenreName genreName : Genre.GenreName.values()){
            Genre genre = new Genre();
            genre.setGenre(genreName.toString());
            switch (genreName){
                case TECHNO:
                    genre.setImageUrl("https://i.ytimg.com/vi/-TlQIFKot_0/hqdefault.jpg");
                    break;
                case HOUSE:
                    genre.setImageUrl("http://orig12.deviantart.net/7de4/f/2010/011/e/9/house_music_by_labelrx.png");
                    break;
                case DUBSTEP:
                    genre.setImageUrl("https://images4.alphacoders.com/244/244286.jpg");
                    break;
                case TRANCE:
                    genre.setImageUrl("http://factmag-images.s3.amazonaws.com/wp-content/uploads/2015/12/trance3-12.11.2015.png");
                    break;
            }
            genres.add(genre);
        }
        adapter = new GenreListAdapter(genres);

        genreDao = new GenreDaoInMemoryImpl();

    }

    @Test
    public void loadAllGenresFromRepositoryAndLoadIntoView() throws ServiceException, AdapterBuilderException {
        presenter.getGenreAdapter(R.layout.genre_layout, null, null);
        verify(genreService).getAllGenresAdapter(eq(R.layout.genre_layout), any(AdapterListener.class), mGenreServiceCallback.capture());
        mGenreServiceCallback.getValue().onSuccess(adapter);
    }
}
