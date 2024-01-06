package com.quintallabs.feature.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.quintallabs.design.components.DrinkCard
import com.quintallabs.design.components.LoadingDialog
import org.koin.androidx.compose.koinViewModel

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
  viewModel: HomeViewModel = koinViewModel(),
) {
  val state = viewModel.state.collectAsState()

  val pullRefreshState = rememberPullRefreshState(
    refreshing = state.value.isLoading,
    onRefresh = viewModel::getNewRandomDrink
  )

  LoadingDialog(state.value.isLoading)

  if(!state.value.isLoading) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopCenter)
        .padding(16.dp)
        .pullRefresh(pullRefreshState)
    ) {
      state.value.randomDrink?.let {

        PullRefreshIndicator(
          refreshing = state.value.isLoading,
          state = pullRefreshState,
          modifier = Modifier
            .wrapContentSize(Alignment.Center),
          backgroundColor = if (state.value.isLoading) Color.Red else Color.Green,
        )

        DrinkCard(
          drink = it
        )
      }
    }
  }
}