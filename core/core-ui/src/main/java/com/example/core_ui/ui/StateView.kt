package com.example.core_ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.example.core_ui.R
import com.example.core_ui.constant.StateViewConstant.EMPTY_MESSAGE_BUTTON_CORNER
import com.example.core_ui.constant.StateViewConstant.EMPTY_MESSAGE_DESC_TO_BUTTON_SPACER
import com.example.core_ui.constant.StateViewConstant.EMPTY_MESSAGE_TITLE_TO_DESC_SPACER
import com.example.core_ui.constant.StateViewConstant.EMPTY_MESSAGE_TOP_SPACER
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_BOX_CORNER
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_BOX_PADDING
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_BUTTON_CORNER
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_BUTTON_FONT_SIZE
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_BUTTON_PADDING
import com.example.core_ui.constant.StateViewConstant.ERROR_MESSAGE_PADDING
import com.example.core_ui.constant.StateViewConstant.LOAD_ROUND_SIZE
import com.example.core_ui.theme.BackgroundAvatar
import com.example.core_ui.theme.BrandGreen
import com.example.core_ui.theme.TextPrimary
import com.example.core_ui.theme.TextSecondary

@Composable
fun LoadRound() {
    Column(
        Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(LOAD_ROUND_SIZE),
            color = TextPrimary
        )
    }
}

@Composable
fun EmptyMessage(
    title: String = stringResource(R.string.empty_title),
    description: String = stringResource(R.string.empty_description),
    buttonText: String = stringResource(R.string.empty_button_text),
    onButtonClick: () -> Unit,
    showButton: Boolean = true,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundAvatar),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(EMPTY_MESSAGE_TOP_SPACER))

        ActionLinkText(
            text = title,
            textColor = TextPrimary
        )

        Spacer(modifier = Modifier.height(EMPTY_MESSAGE_TITLE_TO_DESC_SPACER))

        CourseDescriptionText(
            text = description,
            textColor = TextSecondary
        )

        if (showButton) {
            Spacer(modifier = Modifier.height(EMPTY_MESSAGE_DESC_TO_BUTTON_SPACER))

            Button(
                onClick = onButtonClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = BrandGreen
                ),
                shape = RoundedCornerShape(EMPTY_MESSAGE_BUTTON_CORNER)
            ) {
                ButtonLabelText(text = buttonText)
            }
        }
    }
}

@Composable
fun ErrorMessage(
    onRetryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(ERROR_MESSAGE_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(ERROR_MESSAGE_BOX_CORNER))
                .background(BackgroundAvatar)
                .padding(ERROR_MESSAGE_BOX_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ActionLinkText(
                text = stringResource(R.string.error_text),
                textColor = TextPrimary
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(Modifier.padding(ERROR_MESSAGE_BUTTON_PADDING)) {
                Button(
                    onClick = onRetryClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = BrandGreen
                    ),
                    shape = RoundedCornerShape(ERROR_MESSAGE_BUTTON_CORNER),
                ) {
                    ButtonLabelText(
                        text = stringResource(R.string.error_button_text),
                        fontSize = ERROR_MESSAGE_BUTTON_FONT_SIZE
                    )
                }
            }
        }
    }
}