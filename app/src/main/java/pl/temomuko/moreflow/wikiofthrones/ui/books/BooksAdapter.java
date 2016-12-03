package pl.temomuko.moreflow.wikiofthrones.ui.books;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.temomuko.moreflow.wikiofthrones.data.model.Book;
import pl.temomuko.moreflow.wikiofthrones.ui.books_detail.BooksDetailActivity;

/**
 * Created by Szymon on 23.10.2016.
 */

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private Context context;

    private List<Book> booksList = new ArrayList<>();

    public BooksAdapter(Context context) {
        this.context = context;
    }

    @Override
    public BooksAdapter.BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BooksAdapter.BookViewHolder holder, int position) {
        final Book book = booksList.get(position);
        holder.nameTextView.setText(book.getName());
        holder.nameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BooksDetailActivity.class);
                intent.putExtra("id", book.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public void setBooks(List<Book> booksList) {
        this.booksList = booksList;
    }

    class BookViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1)
        TextView nameTextView;

        public BookViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
