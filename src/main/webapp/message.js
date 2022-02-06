/**
 * 
 */
function popupMessages(infoMessage) {

	const message = infoMessage;
	console.log(message);
	switch (message) {

		case "Successfully Added":

			swal.fire({
				title: "Successfully Added!",
				icon: "success",
				showConfirmButton: false,
				timer: 2000
			});
			break;

		case "Venues not added":

			swal.fire({
				title: "Not Added!Try again Later",
				icon: "Error",
				showConfirmButton: false,
				timer: 2000
			});
			break;
		case "Inactive Successfully":
			swal.fire({
				title: "Inactive successfully",
				icon: "success",
				showConfirmButton: false,
				timer: 2000
			});
			break;
		case "not inactive successfully":

			swal.fire({
				title: "not inactive successfully try again later",
				icon: "Error",
				showConfirmButton: false,
				timer: 2000
			});
			break;

	}

}
function inactiveVenue(venueId) {
	Swal.fire({
		title: "Are you sure? You Want to inactive this Venue",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: 'inactive',
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		timer: 4000
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("inactiveVenue?venue=&venueIdAdmin=" + venueId);
		}


	})
}
