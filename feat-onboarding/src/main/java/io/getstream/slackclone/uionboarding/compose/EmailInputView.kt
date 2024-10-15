package io.getstream.slackclone.uionboarding.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.getstream.slackclone.commonui.theme.SlackCloneColorProvider
import io.getstream.slackclone.commonui.theme.SlackCloneTypography

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun EmailInputView(
  modifier: Modifier = Modifier,
  onBoardingVM: OnBoardingVM
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .wrapContentWidth()
  ) {
    Text(
      text = "Email",
      style = SlackCloneTypography.caption.copy(
        color = SlackCloneColorProvider.colors.textPrimary.copy(alpha = 0.7f),
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Start
      ),
      modifier = Modifier.padding(bottom = 4.dp)
    )
    Row(
      modifier = modifier
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Start
    ) {
      EmailTF(onBoardingVM)
    }
  }
}

@ExperimentalComposeUiApi
@Composable
private fun EmailTF(onBoardingVM: OnBoardingVM) {
  val email = onBoardingVM.input.collectAsState()
  val keyboardController = LocalSoftwareKeyboardController.current

  TextField(
    value = email.value,
    onValueChange = { newEmail ->
      onBoardingVM.input.value = newEmail
    },
    textStyle = textStyleField(),
    leadingIcon = {
      Icon(
        imageVector = Icons.Default.Email,
        contentDescription = null,
        tint = SlackCloneColorProvider.colors.textPrimary
      )
    },
    placeholder = {
      Text(
        text = "Your email address",
        style = textStyleField(),
        textAlign = TextAlign.Start
      )
    },
    keyboardOptions = KeyboardOptions.Default.copy(
      autoCorrectEnabled = false,
      keyboardType = KeyboardType.Email,
      imeAction = ImeAction.Done,
    ),
    keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    colors = textFieldColors(),
    singleLine = true,
    maxLines = 1
  )
}

@Composable
private fun textFieldColors() = TextFieldDefaults.textFieldColors(
  backgroundColor = Color.Transparent,
  cursorColor = SlackCloneColorProvider.colors.textPrimary,
  unfocusedIndicatorColor = Color.Transparent,
  focusedIndicatorColor = Color.Transparent
)

@Composable
private fun textStyleField() = SlackCloneTypography.h6.copy(
  color = SlackCloneColorProvider.colors.textPrimary,
  fontWeight = FontWeight.Normal,
  textAlign = TextAlign.Start
)
