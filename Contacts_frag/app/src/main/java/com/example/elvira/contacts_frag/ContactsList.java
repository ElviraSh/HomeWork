package com.example.elvira.contacts_frag;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

public class ContactsList extends AppCompatActivity implements OnItemClick {

    //private static final int PICK_RESULT = 10;
    private FrameLayout mFrameLayout;
    private RecyclerView mRecyclerView;
    private ContactsRecyclerAdapter mRecyclerAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Contact> mContacts;
    private ArrayList<Contact> mDelContacts;
    private boolean isPortOrient;

    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        mFrameLayout = (FrameLayout) findViewById(R.id.frame_layout);




        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDelContacts = new ArrayList<>();
        createContact();


        mRecyclerAdapter = new ContactsRecyclerAdapter(ContactsList.this, mContacts, this, false);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        isPortOrient = isPort();


    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (mRecyclerView.getVisibility() == View.INVISIBLE) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mFrameLayout.setVisibility(View.INVISIBLE);
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean isPort() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return true;
        else
            return false;
    }

    public void createContact() {
/*
        Intent pickIntent = new Intent(Intent.ACTION_GET_CONTENT);
        pickIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
        startActivityForResult(pickIntent, PICK_RESULT);*/


        mContacts = new ArrayList<>();
        mContacts.add(new Contact("89176431355", "Мамочка"));
        mContacts.add(new Contact("89124546555", "Папуля"));
        mContacts.add(new Contact("89656423423", "Абый"));
        mContacts.add(new Contact("89464366246", "Айгуль"));
        mContacts.add(new Contact("89546578654", "Лиля"));
        mContacts.add(new Contact("89823546768", "Апам"));
        mContacts.add(new Contact("89234365768", "Бабуля"));
        mContacts.add(new Contact("89877654456", "Дедуля"));
        mContacts.add(new Contact("89871327683", "Дэу Эни"));
        mContacts.add(new Contact("89874364362", "Дэу абый"));
        mContacts.add(new Contact("89145674668", "Дэу апа"));
        mContacts.add(new Contact("89453423645", "Тетя"));
}

    @Override
    public void onItemClick(Contact contact) {

        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("contact", contact);
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, detailsFragment, DetailsFragment.class.getSimpleName()).commit();
        if (isPortOrient) {
            mFrameLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void deleteContact(Contact contact) {
        mDelContacts.add(contact);


        RemovesFragment removesFragment = new RemovesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("contacts", mDelContacts);
        removesFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, removesFragment, DetailsFragment.class.getSimpleName()).commit();
        if (isPortOrient) {
            mFrameLayout.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.INVISIBLE);
        }
    }
}

class ContactsRecyclerAdapter extends RecyclerView.Adapter<ContactsRecyclerAdapter.ViewHolder> {
    private ArrayList<Contact> contacts;
    public Context context;
    public OnItemClick click;
    public boolean isRemoved;

    public ContactsRecyclerAdapter(Context context, ArrayList<Contact> contacts, OnItemClick listener, boolean isRemoved){
        this.contacts = contacts;
        this.context = context;
        click = listener;
        this.isRemoved = isRemoved;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(contacts.get(position).getName());
        holder.number.setText(contacts.get(position).getNumber());


        if(!isRemoved) {
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.onItemClick(contacts.get(position));
                }
            });


            holder.view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    new MaterialDialog.Builder(context)
                            .title("Вы действительно хотите удалить контакт?")
                            .positiveText("Удалить")
                            .negativeText("Отмена")
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    dialog.dismiss();
                                }
                            })
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    click.deleteContact(contacts.get(position));
                                    contacts.remove(position);
                                    notifyDataSetChanged();
                                }
                            })
                            .build().show();
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        TextView number;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.number = (TextView) itemView.findViewById(R.id.number);
        }
    }

}

