package fr.iutbm.horube.android_projet;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

/**
 * A list fragment representing a list of Items. This fragment also supports
 * tablet devices by allowing list items to be given an 'activated' state upon
 * selection. This helps indicate which item is currently being viewed in a
 * {@link ItemDetailFragment}.
 * <p>
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class ItemListFragment extends ListFragment {
	private List<GtsModele> lstGtsModele;

	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * activated item position. Only used on tablets.
	 */
	private static final String STATE_ACTIVATED_POSITION = "activated_position";

	/**
	 * The fragment's current callback object, which is notified of list item
	 * clicks.
	 */
	private Callbacks mCallbacks = sDummyCallbacks;

	/**
	 * The current activated item position. Only used on tablets.
	 */
	private int mActivatedPosition = ListView.INVALID_POSITION;

	/**
	 * A callback interface that all activities containing this fragment must
	 * implement. This mechanism allows activities to be notified of item
	 * selections.
	 */
	public interface Callbacks {
		/**
		 * Callback for when an item has been selected.
		 */
		public void onItemSelected(String id);
	}

	/**
	 * A dummy implementation of the {@link Callbacks} interface that does
	 * nothing. Used only when this fragment is not attached to an activity.
	 */
	private static Callbacks sDummyCallbacks = new Callbacks() {
		@Override
		public void onItemSelected(String id) {
		}
	};

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public ItemListFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*setListAdapter(new ArrayAdapter<GtsModelContent.GtsModel>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1, GtsModelContent.ITEMS));*/
		
		lstGtsModele = getGtsModele();
		setListAdapter(new GtsModeleAdapter(getActivity(), lstGtsModele));
	}

	private List<GtsModele> getGtsModele() {
		List<GtsModele> lst = new ArrayList<GtsModele>();
		
		lst.add(new GtsModele("1","Lapin", "http://www.gts.sourceforge.net/samples/bunny.gts.gz", R.drawable.lapin, "/lapin"));
		lst.add(new GtsModele("2","Cube", "http://www.gts.sourceforge.net/samples/cube.gts.gz", R.drawable.cube, "/lapin"));
		lst.add(new GtsModele("3","Ruban", "http://www.gts.sourceforge.net/samples/helix2.gts.gz", R.drawable.ruban, "/lapin"));
		lst.add(new GtsModele("4","Sphere", "http://www.gts.sourceforge.net/samples/epcot.gts.gz", R.drawable.sphere, "/lapin"));
		lst.add(new GtsModele("5","Cheval", "http://www.gts.sourceforge.net/samples/horse.gts.gz", R.drawable.cheval, "/lapin"));
		lst.add(new GtsModele("6","Pyramide", "http://www.gts.sourceforge.net/samples/cone.gts.gz", R.drawable.pyramide, "/lapin"));
		lst.add(new GtsModele("7","Tête", "http://www.gts.sourceforge.net/samples/head.gts.gz", R.drawable.tete, "/lapin"));
		lst.add(new GtsModele("8","Coupe", "http://www.gts.sourceforge.net/samples/goblet.gts.gz", R.drawable.coupe, "/lapin"));
		
		return lst;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		// Restore the previously serialized activated item position.
		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
			setActivatedPosition(savedInstanceState
					.getInt(STATE_ACTIVATED_POSITION));
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		// Activities containing this fragment must implement its callbacks.
		if (!(activity instanceof Callbacks)) {
			throw new IllegalStateException(
					"Activity must implement fragment's callbacks.");
		}

		mCallbacks = (Callbacks) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();

		// Reset the active callbacks interface to the dummy implementation.
		mCallbacks = sDummyCallbacks;
	}

	@Override
	public void onListItemClick(ListView listView, View view, int position,
			long id) {
		super.onListItemClick(listView, view, position, id);

		// Notify the active callbacks interface (the activity, if the
		// fragment is attached to one) that an item has been selected.
		//mCallbacks.onItemSelected(GtsModelContent.ITEMS.get(position).id);
		mCallbacks.onItemSelected(lstGtsModele.get(position).id);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mActivatedPosition != ListView.INVALID_POSITION) {
			// Serialize and persist the activated item position.
			outState.putInt(STATE_ACTIVATED_POSITION, mActivatedPosition);
		}
	}

	/**
	 * Turns on activate-on-click mode. When this mode is on, list items will be
	 * given the 'activated' state when touched.
	 */
	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}

	private void setActivatedPosition(int position) {
		if (position == ListView.INVALID_POSITION) {
			getListView().setItemChecked(mActivatedPosition, false);
		} else {
			getListView().setItemChecked(position, true);
		}

		mActivatedPosition = position;
	}
}
