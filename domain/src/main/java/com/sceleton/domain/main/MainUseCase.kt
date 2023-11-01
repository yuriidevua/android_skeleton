package com.sceleton.domain.main

import com.sceleton.portdata.IRepositoryDAO
import com.sceleton.portdomain.main.IMainUseCase
import javax.inject.Inject

class MainUseCase @Inject constructor(repositoryDAO: IRepositoryDAO) : IMainUseCase {
    override fun startCase() {

    }

    override fun stopCase() {

    }
}