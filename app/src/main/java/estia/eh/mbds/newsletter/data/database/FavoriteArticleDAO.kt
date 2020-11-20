package estia.eh.mbds.newsletter.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import estia.eh.mbds.newsletter.models.FavoriteArticle

@Dao
interface FavoriteArticleDAO {
    @Query("SELECT * FROM favoriteArticle ORDER BY id DESC")
    fun getAll(): LiveData<List<FavoriteArticle>>

    @Query("SELECT title FROM favoriteArticle")
    fun getAllFavoriteArticlesTitle(): LiveData<MutableList<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteArticle: FavoriteArticle)

    @Delete
    suspend fun delete(favoriteArticle: FavoriteArticle)

    @Query("DELETE FROM favoriteArticle WHERE title = :articleTitle")
    suspend fun deleteFavoriteByArticleTitle(articleTitle: String)
}