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

    fun setImages(images: List<Uri>) {
        imageList.clear()
        imageList.addAll(images)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    fun addImage(uri: Uri) {
        imageList.add(uri)
        notifyItemInserted(imageList.size - 1)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketImageView: ImageView = itemView.findViewById(R.id.imageViewTicket)
        private val userImageView: ImageView = itemView.findViewById(R.id.imageViewUser)

        fun bind(uri: Uri) {
            // 티켓 기본 이미지 설정 (이미 설정된 상태라면 생략 가능)
            ticketImageView.setImageResource(R.drawable.ticket_background)

            // 사용자 이미지 설정
            userImageView.setImageURI(uri)
        }
    }
}

