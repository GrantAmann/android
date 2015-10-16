/**
 *   ownCloud Android client application
 *
 *   @author masensio
 *   Copyright (C) 2015 ownCloud Inc.
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License version 2,
 *   as published by the Free Software Foundation.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.owncloud.android.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.owncloud.android.R;
import com.owncloud.android.lib.resources.shares.OCShare;
import com.owncloud.android.lib.resources.shares.ShareType;

import java.io.File;
import java.util.ArrayList;

/**
 * Adapter to show a user/group in Share With List
 */
public class ShareUserListAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<OCShare> mShares;

    public ShareUserListAdapter(Context context, int resource, ArrayList<OCShare>shares) {
        super(context, resource);
        mContext= context;
        mShares = shares;
    }

    @Override
    public int getCount() {
        return mShares.size();
    }

    @Override
    public Object getItem(int position) {
        return mShares.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflator = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View rowView = inflater.inflate(R.layout.row_estacion, parent, false);
        View view = inflator.inflate(R.layout.share_user_item, parent, false);

        if (mShares != null && mShares.size() > position) {
            OCShare share = mShares.get(position);

            TextView userName = (TextView) view.findViewById(R.id.userOrGroupName);
            String name = share.getSharedWithDisplayName();
            if (share.getShareType() == ShareType.GROUP){
                name = name + "(group)";
            }
            userName.setText(name);
        }

        return view;
    }
}
