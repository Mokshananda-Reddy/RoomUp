import React from 'react';
import { render, screen} from '@testing-library/react';
import { MemoryRouter} from "react-router-dom";
import Blist from "../blist/Blist";
import '@testing-library/jest-dom/extend-expect';


test('renders add block manager button', () => {
    render(<MemoryRouter><Blist /></MemoryRouter>);
    const blocktext = screen.getByText('Add a new Block Manager');
    expect(blocktext).toBeInTheDocument();
});