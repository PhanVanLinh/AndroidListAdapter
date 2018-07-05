package toong.com.androidlistadapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class ContactAdapter extends ListAdapter<Contact, ContactAdapter.ContactViewHolder> {
    public ContactAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact contact = getItem(position);
        holder.name.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
    }

    private static final DiffUtil.ItemCallback<Contact> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Contact>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull Contact oldUser, @NonNull Contact newUser) {
                    // User properties may have changed if reloaded from the DB, but ID is fixed
                    return true;
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull Contact oldUser, @NonNull Contact newUser) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldUser.equals(newUser);
                }
            };

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView name, phoneNumber;

        ContactViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_contact_name);
            phoneNumber = itemView.findViewById(R.id.tv_contact_phone_number);
        }
    }
}