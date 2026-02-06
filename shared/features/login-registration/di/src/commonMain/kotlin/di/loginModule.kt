package di

import com.teacherry.loginregistration.domain.login.LoginRepository
import com.teacherry.loginregistration.data.LoginRepositoryImpl
import com.teacherry.loginregistration.presentation.login.LoginViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val loginModule = module {
    singleOf(::LoginRepositoryImpl).bind<LoginRepository>()

    viewModelOf(::LoginViewModel)
}