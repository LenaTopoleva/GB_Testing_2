package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.details.ViewDetailsContract
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttach_attachView(){
        Assert.assertNotNull(presenter.getViewContract())
    }

    @Test
    fun onIncrement_invokeViewSetCountMethod(){
        presenter.onIncrement()
        verify(viewContract, Mockito.times(1)).setCount(anyInt())
    }

    @Test
    fun onDecrement_invokeViewSetCountMethod(){
        presenter.onDecrement()
        verify(viewContract, Mockito.times(1)).setCount(anyInt())
    }

    @Test
    fun onDetach_detachView(){
        presenter.onDetach()
        Assert.assertNull(presenter.getViewContract())
    }

}