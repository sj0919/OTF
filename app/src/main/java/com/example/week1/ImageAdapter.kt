import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    private val imageList = mutableListOf<Uri>()

    // 기존에 이미지 URI들을 받아오는 메서드
    fun setImages(images: List<Uri>) {
        imageList.clear()  // 기존 아이템을 클리어
        imageList.addAll(images)  // 새로 받은 이미지를 추가
        notifyDataSetChanged()  // RecyclerView를 갱신
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    // 이미지 리스트에 이미지 추가
    fun addImage(uri: Uri) {
        imageList.add(uri)
        notifyItemInserted(imageList.size - 1)
    }

    // ViewHolder
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewItem)

        fun bind(uri: Uri) {
            imageView.setImageURI(uri)  // ImageView에 URI로 이미지를 표시
        }
    }
}

