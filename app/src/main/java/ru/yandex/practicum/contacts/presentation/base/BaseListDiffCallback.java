package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T>{



    // В задании написано заменить метод theSame на areItemsTheSame
    // т.к. по одному из принципов наследования мы по идее мы должны наследовать всё
    // или я чтото неправильно сделал?
    // ПО работает, проверил через wifi дебаг в студии на своём телефоне.
    public boolean theSameAs(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }

    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return false;
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.equals(newItem);
    }

    @Nullable
    @Override
    public Object getChangePayload(@NonNull T oldItem, @NonNull T newItem) {
        return newItem;
    }
}
