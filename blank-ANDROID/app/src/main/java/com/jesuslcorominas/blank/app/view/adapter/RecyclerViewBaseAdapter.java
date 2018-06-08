package com.jesuslcorominas.blank.app.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.jesuslcorominas.blank.app.view.adapter.item.ItemView;
import com.jesuslcorominas.blank.app.view.control.ViewWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase base para loa adaptadores de la aplicacion.
 * <p>
 * La clase esta parametrizada con el VO que se va mostrar en pantalla y la vista que lo va a mostrar
 * que debera implementar {@link com.jesuslcorominas.blank.app.view.adapter.item.ItemView}.
 * <p>
 * Created by Jesus Lopez Corominas on 08/06/2018.
 *
 * @see @link(https://github.com/excilys/androidannotations/wiki/Adapters-and-lists)
 */
public abstract class RecyclerViewBaseAdapter<T, V extends View & ItemView<T>> extends RecyclerView.Adapter<ViewWrapper<V>> {

    private static final String TAG = RecyclerViewBaseAdapter.class.getName();

    protected List<T> items /*= new ArrayList<>()*/;

    private OnItemClickListener<T, V> itemClickListener;
    private OnItemLongClickListener<T, V> itemLongClickListener;

    private boolean multiSelect = false;
    private ArrayList<Integer> selectedItems = new ArrayList<Integer>();

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        } else {
            return 0;
        }
    }

    @Override
    public void onBindViewHolder(ViewWrapper<V> viewHolder, final int position) {
        final V view = viewHolder.getView();
        final T data = items.get(position);

        view.bind(data);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(position, view, data);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return onLongItemClick(position, view, data);
            }
        });
    }

    @Override
    public final ViewWrapper<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<V>(onCreateItemView(parent, viewType));
    }

    public final void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public final void addItems(List<T> items) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public final void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public final void update(T modifiedItem) {
        int index = items.indexOf(modifiedItem);
        if (index != -1) {
            items.set(index, modifiedItem);
        } else {
            Log.w(TAG, "No se ha podido actualizar el listado porque el elemento no existia");
        }

        notifyDataSetChanged();
    }

    public final void delete(T deletedItem) {
        int index = items.indexOf(deletedItem);
        if (index != -1) {
            items.remove(index);
        }
        notifyDataSetChanged();
    }

    public List<T> getItems() {
        return items;
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    // ==============================
    // OnItemClickListener
    // ==============================
    private void onItemClick(int position, V view, T data) {
        if (itemClickListener != null) {
            itemClickListener.onItemClick(position, view, data);
        }
    }

    private boolean onLongItemClick(int position, V view, T data) {
        return itemLongClickListener != null && itemLongClickListener.onLongItemClick(position, view, data);
    }

    public void setOnItemClickListener(OnItemClickListener<T, V> listener) {
        this.itemClickListener = listener;
    }

    public void setOnLongItemClickListener(OnItemLongClickListener<T, V> listener) {
        this.itemLongClickListener = listener;
    }

    public interface OnItemClickListener<T, V> {
        void onItemClick(int position, V view, T data);
    }

    public interface OnItemLongClickListener<T, V> {
        boolean onLongItemClick(int position, V view, T data);
    }


}
