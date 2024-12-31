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
        holder.bind(imageList[position],position)
    }

    override fun getItemCount(): Int = imageList.size

    fun addImage(uri: Uri) {
        imageList.add(uri)
        notifyItemInserted(imageList.size - 1)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ticketImageView: ImageView = itemView.findViewById(R.id.imageViewTicket)
        private val userImageView: ImageView = itemView.findViewById(R.id.imageViewUser)

        fun bind(uri: Uri, position: Int) {
            if (position % 8 == 0) {
                ticketImageView.setImageResource(R.drawable.ticket_background)
            } else if(position%8==1){
                ticketImageView.setImageResource(R.drawable.ticket_background2)
            }else if(position%8==2){
                ticketImageView.setImageResource(R.drawable.ticket_background3)
            }else if(position%8==3){
                ticketImageView.setImageResource(R.drawable.ticket_background4)
            }else if(position%8==4){
                ticketImageView.setImageResource(R.drawable.ticket_background5)
            }else if(position%8==5){
                ticketImageView.setImageResource(R.drawable.ticket_background6)
            }else if(position%8==6){
                ticketImageView.setImageResource(R.drawable.ticket_background7)
            }else{
                ticketImageView.setImageResource(R.drawable.ticket_background8)
            }

            // 사용자 이미지 설정
            userImageView.setImageURI(uri)
        }
    }
}

