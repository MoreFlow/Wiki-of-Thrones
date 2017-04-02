package pl.temomuko.moreflow.wikiofthrones.ui.books_detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.temomuko.moreflow.wikiofthrones.R;
import pl.temomuko.moreflow.wikiofthrones.data.model.Character;
import pl.temomuko.moreflow.wikiofthrones.data.remote.WikiService;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder> {

    private List<String> linksToCharactersList = new ArrayList<>();
    private List<Character> charactersList = new ArrayList<>();

    private Context context;

    public CharacterListAdapter(Context context) {
        this.context = context;
    }


    @Override
    public CharacterListAdapter.CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);
        return new CharacterListAdapter.CharacterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CharacterListAdapter.CharacterViewHolder holder, int position) {
        final Character character = charactersList.get(position);
        holder.nameTextView.setText(character.getName());
//        holder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, BooksDetailActivity.class);
//                intent.putExtra("id", book.getId());
//                context.startActivity(intent);
//            }
//        });
    }

    public void setCharacters(List<Character> charactersList) {
        this.charactersList = charactersList;
        notifyDataSetChanged();
    }


    class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_character_name)
        TextView nameTextView;

        public CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return linksToCharactersList.size();
    }
}
