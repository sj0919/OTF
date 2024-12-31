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
            if (position % 24 == 0) {
                ticketImageView.setImageResource(R.drawable.ticket_background)
            }else if(position%24==1){
                ticketImageView.setImageResource(R.drawable.ticket_background2)
            }else if(position%24==2){
                ticketImageView.setImageResource(R.drawable.ticket_background3)
            }else if(position%24==3){
                ticketImageView.setImageResource(R.drawable.ticket_background4)
            }else if(position%24==4){
                ticketImageView.setImageResource(R.drawable.ticket_background5)
            }else if(position%24==5){
                ticketImageView.setImageResource(R.drawable.ticket_background6)
            }else if(position%24==6){
                ticketImageView.setImageResource(R.drawable.ticket_background7)
            }else if(position%24==7){
                ticketImageView.setImageResource(R.drawable.ticket_background8)
            }else if(position%24==8){
                ticketImageView.setImageResource(R.drawable.ticket9)
            }else if(position%24==9){
                ticketImageView.setImageResource(R.drawable.ticket10)
            }else if(position%24==10){
                ticketImageView.setImageResource(R.drawable.ticket11)
            }else if(position%24==11){
                ticketImageView.setImageResource(R.drawable.ticket12)
            }else if(position%24==12){
                ticketImageView.setImageResource(R.drawable.ticket13)
            }else if(position%24==13){
                ticketImageView.setImageResource(R.drawable.ticket14)
            }else if(position%24==14){
                ticketImageView.setImageResource(R.drawable.ticket15)
            }else if(position%24==15){
                ticketImageView.setImageResource(R.drawable.ticket16)
            }else if(position%24==16){
                ticketImageView.setImageResource(R.drawable.ticket17)
            }else if(position%24==17){
                ticketImageView.setImageResource(R.drawable.ticket18)
            }else if(position%24==18){
                ticketImageView.setImageResource(R.drawable.ticket19)
            }else if(position%24==19){
                ticketImageView.setImageResource(R.drawable.ticket20)
            }else if(position%24==20){
                ticketImageView.setImageResource(R.drawable.ticket21)
            }else if(position%24==21){
                ticketImageView.setImageResource(R.drawable.ticket22)
            }else if(position%24==22){
                ticketImageView.setImageResource(R.drawable.ticket23)
            }else{
                ticketImageView.setImageResource(R.drawable.ticket24)
            }

            // 사용자 이미지 설정
            userImageView.setImageURI(uri)
        }
    }
}

