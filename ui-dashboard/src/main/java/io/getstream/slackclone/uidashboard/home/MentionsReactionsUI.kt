package io.getstream.slackclone.uidashboard.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import io.getstream.chat.android.compose.ui.theme.ChatTheme
import io.getstream.slackclone.commonui.material.SlackSurfaceAppBar
import io.getstream.slackclone.commonui.theme.SlackCloneColorProvider
import io.getstream.slackclone.commonui.theme.SlackCloneSurface
import io.getstream.slackclone.commonui.theme.SlackCloneTypography
import io.getstream.slackclone.uichannels.R
import io.getstream.slackclone.uichannels.directmessages.EmptyContent

@Composable
fun MentionsReactionsUI() {
  SlackCloneSurface(
    color = SlackCloneColorProvider.colors.uiBackground,
    modifier = Modifier.fillMaxSize()
  ) {
    Column {
      MRTopAppBar()
      ChatTheme {
        EmptyContent(
          modifier = Modifier.fillMaxSize(),
          painter = painterResource(id = R.drawable.stream_compose_empty_channels),
          text = stringResource(R.string.stream_compose_message_list_empty_messages),
        )
      }
    }
  }
}

@Composable
private fun MRTopAppBar() {
  SlackSurfaceAppBar(
    title = {
      Text(
        text = "Mentions & Reactions",
        style = SlackCloneTypography.h5.copy(color = Color.White, fontWeight = FontWeight.Bold)
      )
    },
    backgroundColor = SlackCloneColorProvider.colors.appBarColor,
  )
}