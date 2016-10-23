package pl.temomuko.moreflow.wikiofthrones.ui.books;

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
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private List<Book> booksList = new ArrayList<>();

    @Override
    public BooksAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.BookViewHolder holder, int position) {
        Book book = booksList.get(position);
        holder.nameTextView.setText(book.getName());
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public void setBooks(List<Book> booksList) {
        this.booksList = booksList;
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_name)
        TextView nameTextView;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
