import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Topbar from "../../components/topbar/Topbar";
import '@testing-library/jest-dom/extend-expect';


test('renders application name in topbar', () => {
  render(<MemoryRouter><Topbar /></MemoryRouter>);
  const title = screen.getByText('RoomUp');
  expect(title).toBeInTheDocument();
});