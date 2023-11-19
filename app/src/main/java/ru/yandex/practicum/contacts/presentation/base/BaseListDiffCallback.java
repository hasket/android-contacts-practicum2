package ru.yandex.practicum.contacts.presentation.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BaseListDiffCallback<T extends ListDiffInterface<T>> extends DiffUtil.ItemCallback<T> implements ListDiffInterface<T>{

    T type;

    /* Снова комментарий=) я уверен, что работа вернётся на доработку=)

    Вот такой вопрос, в задании написано:
    Шаг 3, действие 1
    "Класс `BaseListDiffCallback` должен быть дженерик-классом
    с ограничением параметра типа на обязательную реализацию интерфейса `ListDiffInterface<>`.
    В качестве параметра типа у интерфейса -> указывается такое же имя, что и у класса <-"

    подставляю имя класса `BaseListDiffCallback` у меня сразу студия показывает связанные проблемы,
    в виде того, что при создании объекта, например:

    private final AsyncListDiffer<ContactUi> differ = new AsyncListDiffer<>(
            new AdapterListUpdateCallback(this),
            new AsyncDifferConfig.Builder<>(new BaseListDiffCallback<ContactUi>()).build()
    );

    у меня ошибка, т.к. неправильно вызываю конкретно объект BaseListDiffCallback<ContactUi>(),
    но далее в задании, указано:

    Вместо `ListDiffCallback` надо лишь указать `BaseListDiffCallback<>`.
    Не забудьте -> указать соответствующее каждому адаптеру имя класса,
    реализующего интерфейс `ListDiffInterface` <-.

    new BaseListDiffCallback<ContactUi>(), но я же правильно это указал.
    что я неправильно понимаю?

     */


    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        // Добавил элемент type, как понял, сюда можно подставлять что угодно, т.к.
        // это потом переопределяется в класах непосредственно реализующие интерфейс.
        // но для корректности решил подставить type.
        return theSameAs(type);
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

    @Override
    public boolean theSameAs(T type) {
        return false;
    }
}
