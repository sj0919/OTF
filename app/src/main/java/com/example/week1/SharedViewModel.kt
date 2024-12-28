import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.net.Uri

class SharedViewModel : ViewModel() {
    // 이미지 URI 리스트
    private val _imageUriList = MutableLiveData<List<Uri>>(emptyList())
    val imageUriList: LiveData<List<Uri>> get() = _imageUriList

    // 이미지 추가 메서드
    fun addImageUri(uri: Uri) {
        val currentList = _imageUriList.value ?: emptyList()
        _imageUriList.value = currentList + uri // 기존 리스트에 새 이미지 추가
    }
}
