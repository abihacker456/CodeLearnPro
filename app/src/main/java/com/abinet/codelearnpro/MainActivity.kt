package com.abinet.codelearnpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        SearchRepository.initialize(applicationContext)
        BookmarkRepository.initialize(applicationContext)

        setContent {
            val themeViewModel: ThemeViewModel = viewModel()
            val progressViewModel: ProgressViewModel = viewModel(
                factory = ProgressViewModelFactory(application)
            )

            CodeLearnProTheme(
                themeViewModel = themeViewModel,
                dynamicColor = true
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route
                    ) {
                        composable(Screen.Home.route) {
                            LanguageSelectionScreen(
                                themeViewModel = themeViewModel,
                                progressViewModel = progressViewModel,
                                onLanguageClick = { languageId ->
                                    navController.navigate(
                                        Screen.LanguageDetail.createRoute(languageId)
                                    )
                                },
                                onAboutClick = {
                                    navController.navigate(Screen.AboutDeveloper.route)
                                },
                                onContactClick = {
                                    navController.navigate(Screen.Contact.route)
                                },
                                onSearchClick = {
                                    navController.navigate(Screen.Search.route)
                                },
                                onBookmarksClick = {
                                    navController.navigate(Screen.Bookmarks.route)
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.LanguageDetail.route) { backStackEntry ->
                            val languageId = backStackEntry.arguments?.getString("languageId")?.toIntOrNull() ?: 1
                            LanguageDetailScreen(
                                languageId = languageId,
                                onBackClick = { navController.popBackStack() },
                                onStartLearning = { langId ->
                                    navController.navigate(Screen.Lessons.createRoute(langId))
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.Lessons.route) { backStackEntry ->
                            val languageId = backStackEntry.arguments?.getString("languageId")?.toIntOrNull() ?: 1
                            LessonScreen(
                                languageId = languageId,
                                progressViewModel = progressViewModel,
                                onBackClick = { navController.popBackStack() },
                                onLessonClick = { clickedLesson ->
                                    navController.navigate(Screen.LessonDetail.createRoute(clickedLesson.id))
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.LessonDetail.route) { backStackEntry ->
                            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: "python_01"
                            val lesson = LessonDataProvider.getLessonById(lessonId)
                            LessonDetailScreen(
                                lesson = lesson,
                                progressViewModel = progressViewModel,
                                onBackClick = { navController.popBackStack() },
                                onTryCodeClick = { clickedLessonId ->
                                    navController.navigate(Screen.CodeExecution.createRoute(clickedLessonId))
                                },
                                onNextLessonClick = { nextLessonId ->
                                    navController.navigate(Screen.LessonDetail.createRoute(nextLessonId))
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.CodeExecution.route) { backStackEntry ->
                            val lessonId = backStackEntry.arguments?.getString("lessonId") ?: "python_01"
                            CodeExecutionScreen(
                                lessonId = lessonId,
                                onBackClick = { navController.popBackStack() },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.AboutDeveloper.route) {
                            AboutDeveloperScreen(
                                onBackClick = { navController.popBackStack() },
                                onContactClick = { navController.navigate(Screen.Contact.route) },
                                progressViewModel = progressViewModel,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.Contact.route) {
                            ContactScreen(
                                onBackClick = { navController.popBackStack() },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.Search.route) {
                            SearchScreen(
                                onBackClick = { navController.popBackStack() },
                                onLessonClick = { clickedLesson ->
                                    navController.navigate(Screen.LessonDetail.createRoute(clickedLesson.id))
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        composable(Screen.Bookmarks.route) {
                            BookmarksScreen(
                                onBackClick = { navController.popBackStack() },
                                onLessonClick = { clickedLesson ->
                                    navController.navigate(Screen.LessonDetail.createRoute(clickedLesson.id))
                                },
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
    }
}