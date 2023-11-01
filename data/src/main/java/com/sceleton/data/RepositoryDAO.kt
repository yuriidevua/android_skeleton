package com.sceleton.data

import com.sceleton.featurelocalstorage.Dao
import com.sceleton.portdata.IRepositoryDAO
import javax.inject.Inject

class RepositoryDAO @Inject constructor(private val dao : Dao) : IRepositoryDAO {
}